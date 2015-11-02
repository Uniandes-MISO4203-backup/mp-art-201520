package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement
public class ClientDTO extends PersonDTO {

    private List<CartItemDTO> cartItem;

    public List<CartItemDTO> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItemDTO> cartitem) {
        this.cartItem = cartitem;
    }
}
