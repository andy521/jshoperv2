package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.classic.Validatable;
import org.springframework.stereotype.Controller;


import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsGroupTService;
import com.jshop.service.impl.GoodsGroupTServiceImpl;
@ParentPackage("jshop")
@Controller("GoodsGroupTAction")
public class GoodsGroupTAction {
	public GoodsGroupTService goodsGroupTService;
	public Serial serial;
	private String groupid;
	private String goodsid;
	private String goodsname;
	private String state;
	private Date begintime;
	private Date endtime;
	private String creatorid;
	private Date createtime;
	private String cashstate;
	private Double cashlimit;
	private int limitbuy;
	private int salequantity;
	private int SOrderCount;
	private int totalOrderCount;
	private double sendpoint;
	private String priceladder;
	private String detail;
	private int total=0;
	private int page=1;
	private int rp;
	private String sortname;//排序字段
	private String sortorder;//排序方式
	private String qtype;
	
	private List rows= new ArrayList();
	@JSON(serialize=false)
	public GoodsGroupTService getGoodsGroupTService() {
		return goodsGroupTService;
	}
	public void setGoodsGroupTService(GoodsGroupTService goodsGroupTService) {
		this.goodsGroupTService = goodsGroupTService;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCashstate() {
		return cashstate;
	}
	public void setCashstate(String cashstate) {
		this.cashstate = cashstate;
	}
	public Double getCashlimit() {
		return cashlimit;
	}
	public void setCashlimit(Double cashlimit) {
		this.cashlimit = cashlimit;
	}
	public int getLimitbuy() {
		return limitbuy;
	}
	public void setLimitbuy(int limitbuy) {
		this.limitbuy = limitbuy;
	}
	public int getSalequantity() {
		return salequantity;
	}
	public void setSalequantity(int salequantity) {
		this.salequantity = salequantity;
	}
	public int getSOrderCount() {
		return SOrderCount;
	}
	public void setSOrderCount(int sOrderCount) {
		SOrderCount = sOrderCount;
	}
	public int getTotalOrderCount() {
		return totalOrderCount;
	}
	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}
	public double getSendpoint() {
		return sendpoint;
	}
	public void setSendpoint(double sendpoint) {
		this.sendpoint = sendpoint;
	}
	public String getPriceladder() {
		return priceladder;
	}
	public void setPriceladder(String priceladder) {
		this.priceladder = priceladder;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}		
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getSortorder() {
		return sortorder;
	}
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	/**
	 * 添加团购商品
	 * @return
	 */
	@Action(value="addGoodsGroupT",results={@Result(name="json",type="json")})
	public String addGoodsGroupT(){
		GoodsGroupT ggt = new GoodsGroupT();		
		ggt.setGroupid(this.getSerial().Serialid(Serial.GOODSGROUPT));
		ggt.setGoodsid(this.getGoodsid().trim());
		ggt.setCreatetime(BaseTools.systemtime());
		ggt.setGoodsname(this.getGoodsname().trim());
		ggt.setCreatorid(this.getCreatorid().trim());
		ggt.setState("0");
		ggt.setCashstate("0");
		ggt.setCashlimit(0.0);
		ggt.setLimitbuy(0);
		ggt.setSalequantity(0);
		ggt.setSOrderCount(0);
		ggt.setTotalOrderCount(0);
		ggt.setBegintime(BaseTools.systemtime());
		ggt.setEndtime(BaseTools.systemtime());
		ggt.setSendpoint(this.getSendpoint());
		ggt.setPriceladder(this.getPriceladder().trim());
		ggt.setDetail(this.getDetail().trim());
		this.getGoodsGroupTService().addGoodsGroupT(ggt);
			return "json";
//		}	
//		return "json";
	}

	/**
	 * 处理迭代商品信息
	 * @param ggtList
	 */
	@SuppressWarnings("unchecked")
	public void ProcessGoodsGroupTList(List<GoodsGroupT> ggtList){
		total = this.getGoodsGroupTService().countAllGoodsGroupT();
		rows.clear();
		for(Iterator it = ggtList.iterator();it.hasNext();){
			GoodsGroupT ggt =(GoodsGroupT) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", ggt.getGroupid());
			cellMap.put("cell", new Object[]{
					ggt.getGoodsid(),
					ggt.getGoodsname(),
					ggt.getPriceladder(),
					ggt.getSendpoint(),
					ggt.getCashlimit(),
					ggt.getBegintime(),
					ggt.getEndtime(),					
					ggt.getCashstate(),
					ggt.getState(),
					ggt.getLimitbuy(),
					ggt.getSalequantity(),
					ggt.getSOrderCount(),
					ggt.getTotalOrderCount(),
					ggt.getDetail()
			});
			rows.add(cellMap);
		}
		
	}
	/**
	 * 获取默认所有的团购商品信息
	 */	
	public  void defaultfindAllGoodsGroupT(){
		int currentPage= page;
		int lineSize = rp;
		if(Validate.StrNotNull(sortname)&&Validate.StrNotNull(sortorder)){
			String queryString = "from GoodsGroupT  order by "+sortname+" "+ sortorder +"";
			List<GoodsGroupT> list = this.getGoodsGroupTService().sortAllGoodsGroup(currentPage, lineSize, queryString);
			if(!list.isEmpty()){
				ProcessGoodsGroupTList(list);
			}
			
		}
		
	}
	/**
	 * 获取所有团购商品的信息
	 * @return
	 */
	@Action(value="findAllGoodsGroupT",results={@Result(name="json",type="json")})
	public String findAllGoodsGroupT(){
		if(this.getQtype().equals("sc")){
			defaultfindAllGoodsGroupT();
		}else{
			if(Validate.StrisNull(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
			
		}
		return "json";
		
	}
	
	
}