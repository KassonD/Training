// Create galaxyStore database
use('galaxyStore');

// Add products coll
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.createCollection('products', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["name", "price", "inStock"],
            additionalProperties: true,
            properties: {
                name: {
                    bsonType: "string",
                    description: "Must be a string"
                },
                price: {
                    bsonType: ["double", "int"],
                    description: "Must be a int"
                },
                inStock: {
                    bsonType: "bool",
                    description: "Must be a boolean"
                }
            }
        }
    },
    validationAction: "error"
});

// Insert 3 different gadgets
// (Wireless Mouse, Mechanical Keyboard, Gaming Monitor)
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.insertMany([
    {name: 'Wireless Mouse', price: 22, inStock: true, specs: {brand: "Logitech"}},
    {name: 'Mechanical Keyboard', price: 95, inStock: true, specs: {brand: "Logitech"}},
    {name: 'Gaming Monitor', price: 279, inStock: false, specs: {brand: "Alienware"}}
]);

// Testing validation
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.insertOne(
    {name: 'Wireless Mouse', inStock: true}
);

// Update one product and add a new top-level field called category with the value "Accessories"
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.updateOne(
    {name: 'Wireless Mouse'},
    {$set: {category: "Accessories"}}
);

// Increase the price by 15
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.updateOne(
    {name: 'Wireless Mouse'},
    {$inc: {price: 15}}
);

// Add wireless array then push bestseller
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.updateOne(
    {name: 'Wireless Mouse'},
    {$push: {tags: "wireless"}}
);
galaxyStoreDB.products.updateOne(
    {name: 'Wireless Mouse'},
    {$push: {tags: "bestseller"}}
);

// Remove wireless tag
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.updateOne(
    {name: 'Wireless Mouse'},
    {$pull: {tags: "wireless"}}
);

// Find all products with a price > an amount
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.products.find(
    {category: {$in: ["Accessories", "Food"]}}
);

// Create orders collection
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.createCollection('orders');

// Insert a document into orders
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
const wirelessMouse = galaxyStoreDB.products.findOne(
    {name: "Wireless Mouse"}
);
galaxyStoreDB.orders.insertOne({
    productId: wirelessMouse._id,
    quantity: 2
});

// Join orders with products
const galaxyStoreDB = db.getSiblingDB('galaxyStore');
galaxyStoreDB.orders.aggregate([
    {$lookup: {from: 'products', localField: 'productId', foreignField: '_id', as: 'product'}},
    {$unwind: '$product'},
    {$project: {productName: '$product.name', quantity: 1, _id: 0}}
]);