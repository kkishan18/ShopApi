package com.shop.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.AdressDto;
import com.shop.dto.ProductDto;
import com.shop.exception.AddressException;
import com.shop.exception.CartException;
import com.shop.exception.LoginException;
import com.shop.exception.OrderExcetion;
import com.shop.model.Address;
import com.shop.model.Cart;
import com.shop.model.Customer;
import com.shop.model.Orders;
import com.shop.model.Session;
import com.shop.repository.CartDao;
import com.shop.repository.CustomerDao;
import com.shop.repository.Orderdao;
import com.shop.repository.SessionDao;



@Service
public class OrderServiceimpl  implements OrderService{

	
	 @Autowired
	  private SessionDao sdo;
	
	 @Autowired
	 private Orderdao od;
	
	 @Autowired
	 private CustomerDao cus;
	
	 
	 @Autowired
	 private CartDao cartdao;
	
	@Override
	public Orders addOrder(Orders order, String key) throws LoginException, CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		
		
		
		    Session ke = sdo.findByuuid(key);
		    
		    if(ke==null)
		    {
		    	throw new LoginException("You are not Authorized");
		    }
		    else
		    {
		    	
		    	
		    	 Integer customerId =  ke.getUserId();
		    	 
		    	 Optional<Customer>  s = cus.findById(customerId);
		    	 
		    	 Address ss = s.get().getAddress();
		    	 
		    	 Orders curr  = new Orders();
		    	 
		    	 curr.setOrderDate(LocalDate.now());
                 curr.setAddress( new AdressDto(ss.getStreetNo(), ss.getBulidingName(), ss.getCity(), ss.getState(), ss.getCountry(), ss.getPincode()));
                 curr.setCustomer(s.get());
                 curr.setOrderStatus("Order Confrimed");
                 
                 
                 List<ProductDto> list = cartdao.findByCustomer(s.get()).getProducts();
                 
                 if( list.size() < 1) {
    				 throw new CartException("Add product to the cart first...");
    			 }
                 
                 
                 
                 List<ProductDto> product = new ArrayList<ProductDto>();
                 
                 Double total = 0.0;
//                 for(ProductDto s: )
		    	
                 
                 for(ProductDto proDto : list) {
    				 
    				 product.add(proDto);
    				 
    				 total += (proDto.getPrice() * proDto.getQuantity()) ;
    				 
    			 }
                 
                 curr.setTotal(total);	
    			 curr.setPoder(product);
    			 
    			 
    			 
               Integer customerI =  ke.getUserId();
		    	 
		    	 Optional<Customer>  t = cus.findById(customerI);
    			 
    			 
    			 Cart customerCart = cartdao.findByCustomer(t.get()) ;
    			 
    			 customerCart.setProducts(new ArrayList<>());
    			 
    			 cartdao.save(customerCart);
    			 
    			 return od.save(curr);
                 
                 
		    }
		    
	
	}

	@Override
	public Orders updateCustomer(Orders order, String key) throws LoginException, CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		
	  Session s = sdo.findByuuid(key);
	  
	  if(s==null)
	  {
		  throw new LoginException("Sorry you are not Authorized");
	  }
	  else
	  {
		  Optional<Orders> opt=  od.findById(order.getOrderId());
		  
		  
		  if(opt.isPresent()) {
				return od.save(order);
			}
			else {
				throw new OrderExcetion("Order does not exist");
			}
		  
	  }
		
		
	}

	@Override
	public Orders removeOrder(Integer id, String key) throws LoginException, CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		Session s = sdo.findByuuid(key);
		
		if(s==null)
			{
			       throw new LoginException("You are not Authorized");
			}
		else
			{
			   Optional<Orders> ss = od.findById(id);
			   
			    if(ss.isEmpty())
			    {
			    	throw new  OrderExcetion("You Don't have orders prodcut");
			    }
			    else
			    {
			    	Orders se = ss.get();
			    	od.deleteById(id);
			    	
			    	return se;
			    }
			     
			}
	}

	@Override
	public Orders viewOrder(Integer id) throws CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		Optional<Orders> s = od.findById(id);
		
		Orders ss = s.get();
		
		
		return ss;
	}

	@Override
	public List<Orders> viewallOrderByDate(LocalDate date) throws OrderExcetion {
		// TODO Auto-generated method stub
		
		
		    List<Orders> s = od.findByorderDate(date);
		
		
		return s;
	}

	@Override
	public List<Orders> orderbylocation(String city) throws OrderExcetion, AddressException {
		// TODO Auto-generated method stub
		
		  
		
//		List<Orders> s = od.getOrderBycity(city);
		return null;
	}

	@Override
	public List<Orders> viewallbyuserid(String userid) throws OrderExcetion {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	
	
	
	
}
