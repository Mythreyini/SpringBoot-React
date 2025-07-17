import React from 'react';

const Footer = () => {
  return (
    <div className="footer">
      <style>{`
        .footer {
          background-color: #2c3e50;
          color: white;
          text-align: center;
          
          font-family: 'Segoe UI', sans-serif;
          font-size: 14px;
          position: fixed;
          bottom: 0;
          width: 100%;
          full-width: 100%;
          left: 0;
          padding: 20px 0;
        }

        @media (max-width: 768px) {
          .footer {
            font-size: 12px;
            padding: 10px 0;
          }
        }
      `}</style>
      <p>Created by Rhythan Varsha J</p>
    </div>
  );
};

export default Footer;
