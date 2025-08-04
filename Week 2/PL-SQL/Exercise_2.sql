-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
CREATE TABLE SAVINGS_ACCOUNTS (
    ACCOUNT_ID    NUMBER PRIMARY KEY,
    CUSTOMER_NAME VARCHAR2(100),
    BALANCE       NUMBER
);

-- Sample data
INSERT INTO SAVINGS_ACCOUNTS VALUES (101, 'Ravi', 5000);
INSERT INTO SAVINGS_ACCOUNTS VALUES (102, 'Priya', 8000);
INSERT INTO SAVINGS_ACCOUNTS VALUES (103, 'Kumar', 10000);
COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR acc IN (SELECT ACCOUNT_ID, BALANCE FROM SAVINGS_ACCOUNTS) LOOP
        UPDATE SAVINGS_ACCOUNTS
        SET BALANCE = BALANCE + (BALANCE * 0.01)
        WHERE ACCOUNT_ID = acc.ACCOUNT_ID;
    END LOOP;

    COMMIT;
END;


BEGIN
    ProcessMonthlyInterest;
END;

-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
CREATE TABLE EMPLOYEES (
    EMPLOYEE_ID   NUMBER PRIMARY KEY,
    NAME          VARCHAR2(100),
    DEPARTMENT    VARCHAR2(50),
    SALARY        NUMBER
);

-- Sample data
INSERT INTO EMPLOYEES VALUES (1, 'Amit', 'HR', 50000);
INSERT INTO EMPLOYEES VALUES (2, 'Sneha', 'IT', 60000);
INSERT INTO EMPLOYEES VALUES (3, 'Ravi', 'IT', 65000);
COMMIT;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE EMPLOYEES
    SET SALARY = SALARY + (SALARY * bonus_percent / 100)
    WHERE DEPARTMENT = dept_name;

    COMMIT;
END;


BEGIN
    UpdateEmployeeBonus('IT', 10);
END;

-- Scenario 3: Customers should be able to transfer funds between their accounts.
CREATE TABLE ACCOUNTS (
    ACCOUNT_ID NUMBER PRIMARY KEY,
    CUSTOMER_NAME VARCHAR2(100),
    BALANCE NUMBER
);

INSERT INTO ACCOUNTS VALUES (201, 'Ravi', 7000);
INSERT INTO ACCOUNTS VALUES (202, 'Priya', 3000);
COMMIT;

CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) AS
    from_balance ACCOUNTS.BALANCE%TYPE;
BEGIN
   
    SELECT BALANCE INTO from_balance FROM ACCOUNTS WHERE ACCOUNT_ID = from_account;

    IF from_balance >= amount THEN
        UPDATE ACCOUNTS
        SET BALANCE = BALANCE - amount
        WHERE ACCOUNT_ID = from_account;

        UPDATE ACCOUNTS
        SET BALANCE = BALANCE + amount
        WHERE ACCOUNT_ID = to_account;

        COMMIT;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;
END;


