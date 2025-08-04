/*
Implementing the Builder Pattern
Scenario: 
You are developing a system to create complex objects such as a Computer with multiple optional parts. Use the Builder Pattern to manage the construction process.
Steps:
1.Create a New Java Project:
  Create a new Java project named BuilderPatternExample.
2.Define a Product Class:
  Create a class Computer with attributes like CPU, RAM, Storage, etc.
3.Implement the Builder Class:
  Create a static nested Builder class inside Computer with methods to set each attribute.
  Provide a build() method in the Builder class that returns an instance of Computer.
4.Implement the Builder Pattern:
  Ensure that the Computer class has a private constructor that takes the Builder as a parameter.
5.Test the Builder Implementation:
  Create a test class to demonstrate the creation of different configurations of Computer using the Builder pattern
*/

// Main.java
package BuilderPattern;

public class Main {
	public static void main(String[] args) {
        // Basic configuration
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM(8)
                .setStorage(256)
                .build();

        // High-end configuration
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(512)
                .setModal("NVIDIA RTX 4090")
                .build();

        System.out.println("Basic Computer:");
        basicComputer.display();

        System.out.println("\nGaming Computer:");
        gamingComputer.display();
    }
}

// Computer.java
package BuilderPattern;

public class Computer {
	private String CPU;
	private int RAM;
	private int storage;
	private String modal;
	
	private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.modal = builder.modal;
    }
	
	public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private String modal;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setModal(String modal) {
            this.modal = modal;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
	}
	
	public void display() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + modal);
    }
}
