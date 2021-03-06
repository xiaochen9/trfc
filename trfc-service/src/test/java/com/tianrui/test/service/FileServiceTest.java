package com.tianrui.test.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tianrui.api.intf.basicFile.measure.IYardManageService;
import com.tianrui.api.intf.businessManage.financeManage.ISalesChargeService;
import com.tianrui.api.intf.businessManage.financeManage.ISalesDetailService;
import com.tianrui.api.intf.businessManage.financeManage.ISalesLedgerService;
import com.tianrui.api.intf.common.IFileService;
import com.tianrui.api.intf.quality.sales.IAssayReportService;
import com.tianrui.api.intf.quality.sales.ISalesBatchnumService;
import com.tianrui.api.intf.system.auth.ISystemRolePermissionsService;
import com.tianrui.api.req.basicFile.measure.YardManageQuery;
import com.tianrui.api.req.businessManage.financeManage.SalesChargeQuery;
import com.tianrui.api.req.businessManage.financeManage.SalesDetailSave;
import com.tianrui.api.req.common.FileUploadReq;
import com.tianrui.api.resp.system.auth.SystemRoleMenuResp;
import com.tianrui.service.impl.system.auth.SystemMenuService;
import com.tianrui.service.impl.system.auth.SystemRolePermissionsService;
import com.tianrui.smartfactory.common.constants.Constant;
import com.tianrui.smartfactory.common.vo.Result;


@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/appliactionContext-service.xml" })
public class FileServiceTest {
	public static Logger logger =LoggerFactory.getLogger(FileServiceTest.class);
//	@Autowired
//	private  IFileService fileService ;
//	@Autowired
//	private IYardManageService yardManageService;
//	@Autowired
//	private ISalesChargeService salesChargeService;
//	@Autowired
//	private ISalesLedgerService salesLedgerService;
//	@Autowired
//	private ISalesDetailService salesDetailService;
//	@Autowired
//	SystemMenuService systemMenuService;
	@Autowired
	ISystemRolePermissionsService iSystemRolePermissionsService;
	@Autowired
	ISalesBatchnumService iSalesBatchnumService;
	@Autowired
	IAssayReportService iAssayReportService;
	/**
	 * 销售化验报告批号详情接口测试
	 * @Title: findSelectDetail 
	 * @Description: TODO
	 * @param @throws Exception   
	 * @return void    
	 * @throws
	 */
	@Test
	public void  findSelectDetail() throws Exception {
		String factorycode="cs110119120";
		Result rs=iAssayReportService.findSelectDetail(factorycode);
	}
	/**
	 * 批号余量计算接口
	 * @Title: selectIdMargin 
	 * @Description: TODO
	 * @param @throws Exception   
	 * @return void    
	 * @throws
	 */
	@Test
	public void  selectIdMargin() throws Exception {
		String material="1002PP10000000006UEY";
		Long weighed =123L;
//		Result rs =iSalesBatchnumService.selectIdMargin(material, weighed);
//		if(!rs.getCode().equals("666666")){
//			System.out.println(rs.getError());
//		}else{
//			System.out.println(rs.getData().toString());
//		}
	}
	@Test
	public void testIphone() throws Exception{
		String id="67d0ff0e6a8d11e7b574ac162d75633c";
//		List<SystemRoleMenuResp> rs = iSystemRolePermissionsService.iphonRole(id);
//		System.out.println(JSON.toJSONString(rs));
	}
	
//	@Test
//	public void test1221() throws Exception{
//		Result rs = systemMenuService.getTreeData();
//		System.out.println(rs.getData());
//	}
//	
//	@Test
//	public void saveTest()throws Exception{
//		FileUploadReq req = new FileUploadReq();
//		req.setFileByte(getBytes("D:\\1.jpg"));
//		req.setuId("111");
//		
//		Result rs =fileService.uploadImg(req);
//		System.out.println(JSON.toJSONString(rs));
//	}
//	
//	@Test
//	public void test1() throws Exception{
//		YardManageQuery query=new YardManageQuery();
//		query.setIsvalid("1");
//		query.setPageNo(1);
//		query.setPageSize(10);
//		Result result=yardManageService.page(query);
//		System.out.println(result);
//	}
//	@Test
//	public void test2() throws Exception{
//		SalesChargeQuery  query=new SalesChargeQuery();
//		query.setPageNo(1);
//		query.setPageSize(10);
//		Result result=salesChargeService.page(query);
//		System.out.println(result.getData());
//	}
//	@Test
//	public void test3() throws Exception{
//		SalesDetailSave bean=new SalesDetailSave();
//		bean.setCode("CK021607310007");
//		bean.setOrdercode("A6SO201607290010");
//		bean.setGoodcode("TH1607300200");
//		bean.setCustomerid("1002P110000000HS975T");
//		bean.setCustomername("深圳嘉族电子商务有限公司河南分公司（李国锋）");
//		bean.setPrice(191.9);
//		bean.setNumber(-22d);
//		bean.setMoney(-4221.8);
//		bean.setDeliveryunit(Constant.ORG_NAME);
//		bean.setConsumetime(1469901630000l);
//		Result result=salesDetailService.add(bean);
//		System.out.println(result.getData());
//		
//	}
//	private byte[] getBytes(String filePath){  
//        byte[] buffer = null;  
//        try {  
//            File file = new File(filePath);  
//            FileInputStream fis = new FileInputStream(file);  
//            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
//            byte[] b = new byte[1000];  
//            int n;  
//            while ((n = fis.read(b)) != -1) {  
//                bos.write(b, 0, n);  
//            }  
//            fis.close();  
//            bos.close();  
//            buffer = bos.toByteArray();  
//        } catch (FileNotFoundException e) {  
//            e.printStackTrace();  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//        return buffer;  
//    } 
}
