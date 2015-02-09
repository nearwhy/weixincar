package com.aero.o2o.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aero.o2o.model.Product;
import com.aero.o2o.model.ProductCategory;
import com.aero.o2o.model.QueryParam;
import com.aero.o2o.model.StandardParam;

@Controller("ProductController")
public class ProductController extends BaseController {
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/productCategorys", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public void queryCategorys(HttpServletRequest request, HttpServletResponse response){
		QueryParam qp = new QueryParam();
		List<ProductCategory> categorys = o2oDao.queryForList("ProductCategory.queryParentCategory", qp);
		renderAjaxData(response, JSONArray.fromObject(categorys).toString());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/productType", method = RequestMethod.GET)
	public String productType(HttpServletRequest request, Map<String, Object> map) throws Exception{
		QueryParam qp = new QueryParam();
		List<ProductCategory> categorys = o2oDao.queryForList("ProductCategory.queryParentCategory", qp);
		if(categorys.size() > 0){
			for (ProductCategory pc : categorys) {
				String hotCategory = "";
				for (int i = 0; i < 2; i++) {
					ProductCategory childPc = pc.getChildCategorys().get(i);
					hotCategory += childPc.getpCategoryName()+"/";
				}
				pc.setHotCategory(hotCategory.substring(0, hotCategory.lastIndexOf("/")));
			}
		}
		map.put("categorys", categorys);
		return "productType";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/showProducts")
	public String showProducts(HttpServletRequest request, Map<String, Object> map){
		Integer categoryId = ServletRequestUtils.getIntParameter(request, "categoryId", 0);
		QueryParam qp = new QueryParam();
		qp.put("categoryId", categoryId);
		List<Product> products = o2oDao.queryForList("Product.queryByCategoryId", qp);
		map.put("products", products);
		map.put("type", "product");
		return "productList";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest request, Map<String, Object> map){
		Integer productId = ServletRequestUtils.getIntParameter(request, "productId", 0);
		QueryParam qp = new QueryParam();
		qp.put("productId", productId);
		Product product = (Product) o2oDao.queryForObject("Product.queryById", qp);
		List<StandardParam> params = o2oDao.queryForList("Product.queryProductParam", qp);
		map.put("product", product);
		map.put("params", params);
		return "productDetail";
	}
}
