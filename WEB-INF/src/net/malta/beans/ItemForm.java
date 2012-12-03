package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class ItemForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
private static final java.text.DateFormat simpleformat = new java.text.SimpleDateFormat("yyyy/MM/dd");private static final java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss");static { format.setLenient(true); }private String note;
public void setNote(String note){
this.note = note;
}
public String getNote(){
return this.note;
}
private Integer id;
public void setId(Integer id){
this.id = id;
}
public Integer getId(){
return this.id;
}
private String no;
public void setNo(String no){
this.no = no;
}
public String getNo(){
return this.no;
}
private int pricewithtax;
public void setPricewithtax(int pricewithtax){
this.pricewithtax = pricewithtax;
}
public int getPricewithtax(){
return this.pricewithtax;
}
private String material;
public void setMaterial(String material){
this.material = material;
}
public String getMaterial(){
return this.material;
}
private String catchcopy;
public void setCatchcopy(String catchcopy){
this.catchcopy = catchcopy;
}
public String getCatchcopy(){
return this.catchcopy;
}
private int stocknum;
public void setStocknum(int stocknum){
this.stocknum = stocknum;
}
public int getStocknum(){
return this.stocknum;
}
private boolean main;
public void setMain(boolean main){
this.main = main;
}
public boolean isMain(){
return this.main;
}
private Integer product;
public void setProduct(Integer product){
this.product = product;
}
public Integer getProduct(){
return this.product;
}
private Integer carriage;
public void setCarriage(Integer carriage){
this.carriage = carriage;
}
public Integer getCarriage(){
return this.carriage;
}
private Integer zoom;
public void setZoom(Integer zoom){
this.zoom = zoom;
}
public Integer getZoom(){
return this.zoom;
}
private Integer defaultattachment;
public void setDefaultattachment(Integer defaultattachment){
this.defaultattachment = defaultattachment;
}
public Integer getDefaultattachment(){
return this.defaultattachment;
}
private String name;
public void setName(String name){
this.name = name;
}
public String getName(){
return this.name;
}
private String size;
public void setSize(String size){
this.size = size;
}
public String getSize(){
return this.size;
}
private String description;
public void setDescription(String description){
this.description = description;
}
public String getDescription(){
return this.description;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	main =false;
}
}
