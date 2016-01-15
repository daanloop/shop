package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class PublicUserForm
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
private String password;
public void setPassword(String password){
this.password = password;
}
public String getPassword(){
return this.password;
}
private String keitai;
public void setKeitai(String keitai){
this.keitai = keitai;
}
public String getKeitai(){
return this.keitai;
}
private String kana;
public void setKana(String kana){
this.kana = kana;
}
public String getKana(){
return this.kana;
}
private String mail;
public void setMail(String mail){
this.mail = mail;
}
public String getMail(){
return this.mail;
}
private int zipthree;
public void setZipthree(int zipthree){
this.zipthree = zipthree;
}
public int getZipthree(){
return this.zipthree;
}
private int zipfour;
public void setZipfour(int zipfour){
this.zipfour = zipfour;
}
public int getZipfour(){
return this.zipfour;
}
private String pref;
public void setPref(String pref){
this.pref = pref;
}
public String getPref(){
return this.pref;
}
private String buildingname;
public void setBuildingname(String buildingname){
this.buildingname = buildingname;
}
public String getBuildingname(){
return this.buildingname;
}
private String phone;
public void setPhone(String phone){
this.phone = phone;
}
public String getPhone(){
return this.phone;
}
private int birthyear;
public void setBirthyear(int birthyear){
this.birthyear = birthyear;
}
public int getBirthyear(){
return this.birthyear;
}
private int birthmonth;
public void setBirthmonth(int birthmonth){
this.birthmonth = birthmonth;
}
public int getBirthmonth(){
return this.birthmonth;
}
private int brithday;
public void setBrithday(int brithday){
this.brithday = brithday;
}
public int getBrithday(){
return this.brithday;
}
private String mailforconfirm;
public void setMailforconfirm(String mailforconfirm){
this.mailforconfirm = mailforconfirm;
}
public String getMailforconfirm(){
return this.mailforconfirm;
}
private String municipality;
public void setMunicipality(String municipality){
this.municipality = municipality;
}
public String getMunicipality(){
return this.municipality;
}
private boolean male;
public void setMale(boolean male){
this.male = male;
}
public boolean isMale(){
return this.male;
}
private boolean removed;
public void setRemoved(boolean removed){
this.removed = removed;
}
public boolean isRemoved(){
return this.removed;
}
private String deliveryname;
public void setDeliveryname(String deliveryname){
this.deliveryname = deliveryname;
}
public String getDeliveryname(){
return this.deliveryname;
}
private int devliveryhour;
public void setDevliveryhour(int devliveryhour){
this.devliveryhour = devliveryhour;
}
public int getDevliveryhour(){
return this.devliveryhour;
}
private int deliverydate;
public void setDeliverydate(int deliverydate){
this.deliverydate = deliverydate;
}
public int getDeliverydate(){
return this.deliverydate;
}
private int deliveryphone;
public void setDeliveryphone(int deliveryphone){
this.deliveryphone = deliveryphone;
}
public int getDeliveryphone(){
return this.deliveryphone;
}
private String deliverykana;
public void setDeliverykana(String deliverykana){
this.deliverykana = deliverykana;
}
public String getDeliverykana(){
return this.deliverykana;
}
private String deliveryblocknumber;
public void setDeliveryblocknumber(String deliveryblocknumber){
this.deliveryblocknumber = deliveryblocknumber;
}
public String getDeliveryblocknumber(){
return this.deliveryblocknumber;
}
private int deliveryzipfour;
public void setDeliveryzipfour(int deliveryzipfour){
this.deliveryzipfour = deliveryzipfour;
}
public int getDeliveryzipfour(){
return this.deliveryzipfour;
}
private int deliveryzipthree;
public void setDeliveryzipthree(int deliveryzipthree){
this.deliveryzipthree = deliveryzipthree;
}
public int getDeliveryzipthree(){
return this.deliveryzipthree;
}
private String deliverypref;
public void setDeliverypref(String deliverypref){
this.deliverypref = deliverypref;
}
public String getDeliverypref(){
return this.deliverypref;
}
private boolean delivertodifferentaddress;
public void setDelivertodifferentaddress(boolean delivertodifferentaddress){
this.delivertodifferentaddress = delivertodifferentaddress;
}
public boolean isDelivertodifferentaddress(){
return this.delivertodifferentaddress;
}
private String deliveryaddress;
public void setDeliveryaddress(String deliveryaddress){
this.deliveryaddress = deliveryaddress;
}
public String getDeliveryaddress(){
return this.deliveryaddress;
}
private String fax;
public void setFax(String fax){
this.fax = fax;
}
public String getFax(){
return this.fax;
}
private boolean registed;
public void setRegisted(boolean registed){
this.registed = registed;
}
public boolean isRegisted(){
return this.registed;
}
private boolean temp;
public void setTemp(boolean temp){
this.temp = temp;
}
public boolean isTemp(){
return this.temp;
}
private String passwordonetimehash;
public void setPasswordonetimehash(String passwordonetimehash){
this.passwordonetimehash = passwordonetimehash;
}
public String getPasswordonetimehash(){
return this.passwordonetimehash;
}
private String name;
public void setName(String name){
this.name = name;
}
public String getName(){
return this.name;
}
private String address;
public void setAddress(String address){
this.address = address;
}
public String getAddress(){
return this.address;
}
private Integer prefecture;
public void setPrefecture(Integer prefecture){
this.prefecture = prefecture;
}
public Integer getPrefecture(){
return this.prefecture;
}
private Integer giftCard;
public void setGiftCard(Integer giftCard){
this.giftCard = giftCard;
}
public Integer getGiftCard(){
return this.giftCard;
}
private boolean hasgiftcard;
public void setHasgiftcard(boolean hasgiftcard){
this.hasgiftcard = hasgiftcard;
}
public boolean isHasgiftcard(){
return this.hasgiftcard;
}
private Date preferreddatedate;
public void setPreferreddatedate(Date preferreddatedate){
this.preferreddatedate = preferreddatedate;
}
public Date getPreferreddatedate(){
return this.preferreddatedate;
}
private boolean preferreddatedateIsValid = false;
public void setPreferreddatedateIsValid(boolean preferreddatedateIsValid){
this.preferreddatedateIsValid = preferreddatedateIsValid;
}
public boolean isPreferreddatedateIsValid(){
return this.preferreddatedateIsValid;
}
private java.lang.String preferreddatedateAsRawString ="";
public java.lang.String getPreferreddatedateAsString(){
    return (preferreddatedate== null) ? null : simpleformat.format(preferreddatedate);
}
public void setPreferreddatedateAsString(java.lang.String preferreddatedate){
	this.preferreddatedateIsValid = true;
	this.preferreddatedateAsRawString = preferreddatedate;
try{
		if(StringUtils.isNotBlank(preferreddatedate)){ simpleformat.parse(preferreddatedate);}
}catch (java.text.ParseException pe){
this.preferreddatedateIsValid = false;
}
	if(preferreddatedateIsValid){
		try {
			this.preferreddatedate = (org.apache.commons.lang.StringUtils.isBlank(preferreddatedate)) ? null : simpleformat.parse(preferreddatedate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public void setPreferreddatedateAsRawString(java.lang.String preferreddatedate){
	this.preferreddatedateAsRawString = preferreddatedate;
}

public String getPreferreddatedateAsRawString(){
return this.preferreddatedateAsRawString;
}
private int preferreddatedateyear = 0;
public void setPreferreddatedateyear(int preferreddatedateyear){
    this.preferreddatedateyear = preferreddatedateyear;
}
public int getPreferreddatedateyear(){
   return this.preferreddatedateyear;
}
private int preferreddatedatemonth = 0;
public void setPreferreddatedatemonth(int preferreddatedatemonth){
    this.preferreddatedatemonth = preferreddatedatemonth;
}
public int getPreferreddatedatemonth(){
   return this.preferreddatedatemonth;
}
private int preferreddatedateday = 0;
public void setPreferreddatedateday(int preferreddatedateday){
    this.preferreddatedateday = preferreddatedateday;
}
public int getPreferreddatedateday(){
   return this.preferreddatedateday;
}
private int preferreddatedatehour = 0;
public void setPreferreddatedatehour(int preferreddatedatehour){
    this.preferreddatedatehour = preferreddatedatehour;
}
public int getPreferreddatedatehour(){
   return this.preferreddatedatehour;
}
private int preferreddatedateminute = 0;
public void setPreferreddatedateminute(int preferreddatedateminute){
    this.preferreddatedateminute = preferreddatedateminute;
}
public int getPreferreddatedateminute(){
   return this.preferreddatedateminute;
}
private int preferreddatedatesecound = 0;
public void setPreferreddatedatesecound(int preferreddatedatesecound){
    this.preferreddatedatesecound = preferreddatedatesecound;
}
public int getPreferreddatedatesecound(){
   return this.preferreddatedatesecound;
}
private boolean preferreddatedatechooser = false;
public void setPreferreddatedatechooser(boolean preferreddatedatechooser){
    this.preferreddatedatechooser = preferreddatedatechooser;
if(this.preferreddatedatechooser){
try{
   Date date = format.parse(preferreddatedateyear + "/" + preferreddatedatemonth + "/" + preferreddatedateday + " " + preferreddatedatehour+ ":" + preferreddatedateminute + ":" + preferreddatedatesecound);   this.preferreddatedate = date;
}catch (java.text.ParseException pe){
		pe.printStackTrace();
}
}}
public boolean isPreferreddatedatechooser(){
   return this.preferreddatedatechooser;
}
private String preferredtime;
public void setPreferredtime(String preferredtime){
this.preferredtime = preferredtime;
}
public String getPreferredtime(){
return this.preferredtime;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	male =false;
	removed =false;
	delivertodifferentaddress =false;
	registed =false;
	temp =false;
	hasgiftcard =false;
}
}
