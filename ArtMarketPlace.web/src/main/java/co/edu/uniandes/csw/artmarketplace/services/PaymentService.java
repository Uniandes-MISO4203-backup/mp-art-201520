package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IPaymentLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.PaymentDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 * @generated
 */
@Path("/payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentService {

    @Inject
    private IPaymentLogic paymentLogic;
    @Context
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    @QueryParam("q")
    private String paymentName;
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public PaymentDTO createPayment(PaymentDTO dto) {
        if (client != null) {
            dto.setClient(client);
            return paymentLogic.createPayment(dto);
        }
        return null;
    }

    /**
     * @generated
     */
    @GET
    public List<PaymentDTO> getPayments() {
        if (paymentName != null) {
            return paymentLogic.findByName(paymentName);
        }
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", paymentLogic.countPayments());
        }
        return paymentLogic.getPayments(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public PaymentDTO getPayment(@PathParam("id") Long id) {
        return paymentLogic.getPayment(id);
    }
    
    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public PaymentDTO updatePayment(@PathParam("id") Long id, PaymentDTO dto) {
        dto.setId(id);
        return paymentLogic.updatePayment(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePayment(@PathParam("id") Long id) {
        paymentLogic.deletePayment(id);
    }
}
