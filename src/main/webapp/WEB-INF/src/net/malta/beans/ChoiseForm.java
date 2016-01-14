package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class ChoiseForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
private static final java.text.DateFormat simpleformat = new java.text.SimpleDateFormat("yyyy/MM/dd");private static final java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss");static { format.setLenient(true); }private Integer id;
private String varietychoise = "";

public String getVarietychoise() {
	return varietychoise;
}
public void setVarietychoise(String varietychoise) {
	this.varietychoise = varietychoise;
}
public void setId(Integer id){
this.id = id;
}
public Integer getId(){
return this.id;
}
private int ordernum;
public void setOrdernum(int ordernum){
this.ordernum = ordernum;
}
public int getOrdernum(){
return this.ordernum;
}
private int pricewithtax;
public void setPricewithtax(int pricewithtax){
this.pricewithtax = pricewithtax;
}
public int getPricewithtax(){
return this.pricewithtax;
}
private boolean wrapping;
public void setWrapping(boolean wrapping){
this.wrapping = wrapping;
}
public boolean isWrapping(){
return this.wrapping;
}
private Integer purchase;
public void setPurchase(Integer purchase){
this.purchase = purchase;
}
public Integer getPurchase(){
return this.purchase;
}
private Integer item;
public void setItem(Integer item){
this.item = item;
}
public Integer getItem(){
return this.item;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	wrapping =false;
}
}
