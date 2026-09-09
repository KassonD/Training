-- Get all fields and records from customer​
SELECT * FROM customer;

-- Get all fields from customer, but only if they are from Arizona​
SELECT * FROM customer
WHERE state LIKE 'AZ';

-- Get all invoices older than 6 months ​
SELECT * FROM invoice
WHERE invoice_date BETWEEN '2026-9-9' AND '2026-4-9';

-- Update all customer phone numbers to NULL if they don’t follow this format: ‘+1 555 555-5555’​
UPDATE customer
SET
    phone = NULL
WHERE phone !~ '\+1 \d{3} \d{3}-\d{4}';

-- Get all tracks that are longer than 180000 milliseconds ​
SELECT * FROM track
WHERE milliseconds > 180000;

-- Update all customers not in the USA so that their country=USA and address, city, & state are NULL​
UPDATE customer
SET
    country = 'USA',
    address = NULL,
    city = NULL,
    state = NULL
WHERE country NOT LIKE 'USA';

-- Given a customer_id, return their total spending across all invoices using a function ​
CREATE OR REPLACE FUNCTION get_total_spending(customer_id INT)
RETURNS NUMERIC AS $$
BEGIN
    RETURN (
        SELECT SUM(total) FROM invoice
        WHERE invoice.customer_id = get_total_spending.customer_id
    );
END;
$$ LANGUAGE plpgsql;

SELECT get_total_spending(2);

-- Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s ReportsTo field.​
--      Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship​
CREATE OR REPLACE PROCEDURE update_reports_to(employee_id INT, new_manager_id INT)
LANGUAGE plpgsql 
AS $$
BEGIN
    IF EXISTS (
            SELECT * FROM employee AS e
            WHERE e.employee_id = update_reports_to.new_manager_id
        )
        AND update_reports_to.employee_id != update_reports_to.new_manager_id
    THEN
        UPDATE employee
        SET
            reports_to = update_reports_to.new_manager_id
        WHERE employee.employee_id = update_reports_to.employee_id;
    END IF;
END;
$$;

CALL update_reports_to(2, 1);

SELECT * FROM employee;

-- Create a new schema: pets​
--      Create two related tables: Customer + Pets​
--      Demonstrate populating records into these tables​
CREATE SCHEMA IF NOT EXISTS pets;
CREATE TABLE IF NOT EXISTS pets.customer (
    customer_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS pets.pets (
    pet_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name TEXT NOT NULL,
    animal TEXT NOT NULL,
    owner_id UUID, 
    
    CONSTRAINT fk_owner_id
    FOREIGN KEY (owner_id)
    REFERENCES pets.customer(customer_id)
);

INSERT INTO pets.customer (first_name, last_name)
VALUES 
    ('John', 'Doe'),
    ('Agent', 'Smith');

SELECT * FROM pets.customer;

INSERT INTO pets.pets (name, animal, owner_id)
VALUES
    ('Spot', 'Golden Doodle', '6b324e28-2846-4b81-9fe7-8330772f7bc0'),
    ('Dash', 'Poodle', 'fef1d8b3-ac30-488c-a0ed-fc8ab97a7df6');

SELECT * FROM pets.pets;