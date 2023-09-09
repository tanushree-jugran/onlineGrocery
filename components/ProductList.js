import React, { useEffect, useState } from "react";

const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const apiEndpoint = "http://localhost:9999/api/products";

    fetch(apiEndpoint)
      .then((response) => response.json())
      .then((data) => {
        if (data && data.length > 0) {
          setProducts(data);
        } else {
          console.error("No product data found in the API response.");
        }
      })
      .catch((error) => {
        console.error("Error fetching product data from the API:", error);
      });
  }, []);

  return (
    <div className="row">
      {products.map((product) => (
        <div key={product.productId} className="col-md-4 col-12">
          <div className="single_product shadow text-center p-1">
            <div className="product_img">
              <a href="product_detail.html">
                <img
                  src={product.imageUrl}
                  className="img img-fluid"
                  alt={product.productName}
                />
              </a>
            </div>
            <div className="product-caption my-3">
              <div className="product-ratting">
                <i className="fas fa-star"></i>
                <i className="fas fa-star"></i>
                <i className="fas fa-star"></i>
                <i className="far fa-star"></i>
                <i className="far fa-star"></i>
              </div>
              <h5>
                <a href="product_detail.html">{product.productName}</a>
              </h5>
              <div className="price">
                <b>
                  <span className="mr-1">₹</span>
                  <span>{product.price}</span>
                </b>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
