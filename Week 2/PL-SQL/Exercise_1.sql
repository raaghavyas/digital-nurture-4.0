CREATE TABLE CUSTOMERS (
    CUSTOMER_ID     NUMBER PRIMARY KEY,
    NAME            VARCHAR2(100),
    AGE             NUMBER,
    LOAN_INTEREST   NUMBER
);

-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
INSERT INTO CUSTOMERS VALUES (1, 'Ravi', 65, 12.5);
INSERT INTO CUSTOMERS VALUES (2, 'Priya', 45, 11.0);
INSERT INTO CUSTOMERS VALUES (3, 'Kumar', 70, 10.0);
COMMIT;

BEGIN
    FOR customer_rec IN (
        SELECT CUSTOMER_ID
        FROM CUSTOMERS
        WHERE AGE > 60
    ) LOOP
        UPDATE CUSTOMERS
        SET LOAN_INTEREST = LOAN_INTEREST * 0.99
        WHERE CUSTOMER_ID = customer_rec.CUSTOMER_ID;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 2: A customer can be promoted to VIP status based on their balance.
ALTER TABLE CUSTOMERS ADD (BALANCE NUMBER, ISVIP VARCHAR2(5));

UPDATE CUSTOMERS SET BALANCE = 8000 WHERE CUSTOMER_ID = 1;
UPDATE CUSTOMERS SET BALANCE = 12000 WHERE CUSTOMER_ID = 2;
UPDATE CUSTOMERS SET BALANCE = 15000 WHERE CUSTOMER_ID = 3;

BEGIN
    FOR cust IN (
        SELECT CUSTOMER_ID, BALANCE
        FROM CUSTOMERS
    ) LOOP
        IF cust.BALANCE > 10000 THEN
            UPDATE CUSTOMERS
            SET ISVIP = 'TRUE'
            WHERE CUSTOMER_ID = cust.CUSTOMER_ID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
CREATE TABLE LOANS (
    LOAN_ID         NUMBER PRIMARY KEY,
    CUSTOMER_ID     NUMBER,
    DUE_DATE        DATE
);

INSERT INTO LOANS VALUES (1, 1, SYSDATE + 10);  -- Due in 10 days
INSERT INTO LOANS VALUES (2, 2, SYSDATE + 40);  -- Due in 40 days
INSERT INTO LOANS VALUES (3, 3, SYSDATE + 5);   -- Due in 5 days
COMMIT;

BEGIN
    FOR loan_rec IN (
        SELECT L.LOAN_ID, C.NAME, L.DUE_DATE
        FROM LOANS L
        JOIN CUSTOMERS C ON L.CUSTOMER_ID = C.CUSTOMER_ID
        WHERE L.DUE_DATE BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan_rec.NAME || 
            ', your loan (ID: ' || loan_rec.LOAN_ID || ') is due on ' || TO_CHAR(loan_rec.DUE_DATE, 'DD-MON-YYYY'));
    END LOOP;
END;
/


