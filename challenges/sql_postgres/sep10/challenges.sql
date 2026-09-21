-- 1. Get all invoice ids with the customers first name, last name, and the invoice total​
SELECT invoice_id, first_name, last_name, total FROM invoice
INNER JOIN customer ON invoice.customer_id = customer.customer_id;

-- 2. Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30.​
SELECT invoice_id, first_name, total FROM invoice
INNER JOIN customer
ON invoice.customer_id = customer.customer_id
WHERE total > 30;

-- 3. Get all the invoices for USA customers in the last 6 months. Use a CTE. ​
WITH us_customers AS (
    SELECT customer_id FROM customer
    WHERE country = 'USA'
)
SELECT * FROM invoice
WHERE customer_id IN (
    SELECT customer_id FROM us_customers
) 
AND invoice_date > NOW() - INTERVAL '6 months';

-- Create a new table called record_logs​
--      Fields: log_id, record_id, field_changed, last_update, old_value, new_value​
CREATE TABLE IF NOT EXISTS record_logs (
    log_id INT NOT NULL,
    record_id INT,
    field_changed TEXT,
    last_update TIMESTAMP DEFAULT NOW() NOT NULL,
    old_value TEXT,
    new_value TEXT,

    CONSTRAINT pk_log_id
    PRIMARY KEY (log_id),
    CONSTRAINT fk_record_id
    FOREIGN KEY (record_id)
    REFERENCES customer(customer_id)
);

-- Create a trigger that tracks changes to customer records and logs the changes in our new table​
CREATE FUNCTION update_record_logs()
RETURNS trigger AS $$
BEGIN
    
END;
$$ language plpgsql;