package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ProductWebService")
public class ProductWebService {

	@GET
	@Path("addNewProduct/{pn}/{pp}/{ps}")
	public boolean addNewProduct(@PathParam("pn")String productName, 
								@PathParam("pp")double productPrice, 
								@PathParam("ps")int productStock)
	{
		Product newpro = new Product(productName,productPrice,productStock);
		boolean result = JDBCManager.save(newpro);
		return result;
	}
	
	@GET
	@Path("deleteProduct/{pid}")
	public boolean deleteProduct(@PathParam("pid")int productID)
	{
		boolean result = JDBCManager.delete(productID);
		return result;
	}
	
	@GET
	@Path("updateProductStock/{pid}/{pp}/{ps}")
	public boolean updateProductStock(@PathParam("pid")int productID, 
									@PathParam("pp")double productPrice,
									@PathParam("ps")int productStock)
	{
		boolean result = JDBCManager.update(productID,productPrice,productStock);
		return result;
	}
}
