The first step you need to do after cloning the project :

open `product_management_db.sql` and execute the syntax in your postgresql


## API Endpoints Documentation

### 1. **User**

#### 🔹 Get All Products
**Endpoint:** `GET /api/products`
**Description:** Retrieve a list of all products.

#### 🔹 Add Products
**Endpoint:** `POST /api/products`
**Description:** Add new products.

#### 🔹 Update Products
**Endpoint:** `PUT /api/products/{id}`
**Description:** Update product data.

#### 🔹 Remove Products
**Endpoint:** `DEL /api/products/{id}`
**Description:** Delete a product.
 

### 2. **Admin**

#### 🔹 Get All Products with pending status
**Endpoint:** `GET /api/products/pending`
**Description:** Retrieve a list of all products with pending status.

#### 🔹 Approve Products
**Endpoint:** `PUT /api/products/{id}/approve`
**Description:** Change the product status to approve.

#### 🔹 Reject Products
**Endpoint:** `PUT /api/products/{id}/reject`
**Description:** Change the product status to reject.
