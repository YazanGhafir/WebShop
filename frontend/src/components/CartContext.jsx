import React from 'react';



export const defaultCartState = {
	products: [],
	updateProducts: () => [],
}
export const CartContext = React.createContext(defaultCartState);

export const CartProvider = (props) => {
 return(
     <CartContext.Provider>
         {props.children}
     </CartContext.Provider>
 )
}