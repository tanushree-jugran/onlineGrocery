// index.js (or App.js)
import React from "react";
import ReactDOM from "react-dom";
import ProductList from "./components/ProductList.js"; // Import your React components here

// Define a sample product data array
const sampleProducts = [
  {
    productId: 1,
    productName: "Product 1",
    imageUrl: "product1.jpg",
    price: 19.99,
  },
  {
    productId: 2,
    productName: "Product 2",
    imageUrl: "product2.jpg",
    price: 29.99,
  },
  // Add more products as needed
];

// Render the ProductList component with the sample product data
ReactDOM.render(
  <ProductList products={sampleProducts} />,
  document.getElementById("root")
);
