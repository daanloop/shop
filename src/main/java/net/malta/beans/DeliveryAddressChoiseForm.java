package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class DeliveryAddressChoiseForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
private static final java.text.DateFormat simpleformat = new java.text.SimpleDateFormat("yyyy/MM/dd");private static final java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss");static { format.setLenient(true); }private Integer id;
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
private String preferreddate;
public void setPreferreddate(String preferreddate){
this.preferreddate = preferreddate;
}
public String getPreferreddate(){
return this.preferreddate;
}
private String preferredtime;
public void setPreferredtime(String preferredtime){
this.preferredtime = preferredtime;
}
public String getPreferredtime(){
return this.preferredtime;
}
private Integer deliveryAddress;
public void setDeliveryAddress(Integer deliveryAddress){
this.deliveryAddress = deliveryAddress;
}
public Integer getDeliveryAddress(){
return this.deliveryAddress;
}
private Integer choise;
public void setChoise(Integer choise){
this.choise = choise;
}
public Integer getChoise(){
return this.choise;
}
private Integer giftCard;
public void setGiftCard(Integer giftCard){
this.giftCard = giftCard;
}
public Integer getGiftCard(){
return this.giftCard;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){}
}
