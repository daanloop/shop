<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/formtag.tld" prefix="formtag" %> 
<%@ taglib uri="/clientsidevalidation.tld" prefix="f" %> 

<%@ page isELIgnored="false" %>

<div id="systemHeader">
<span id="menu">
               		<a href="J2eeStorys.do">Stories</a>
			    	<a href="J2eeStoryDetail.do">new Story</a>
                 	<a href="Verbs.do">Verbs</a>
                	<a href="VerbDetail.do">new verb</a>
               		<a href="Nouns.do">Nouns</a>
               		<a href="NounDetail.do">new Noun</a>-
              		<a href="NounClauses.do">Noun Clauses</a>
					<a href="NewNounClause.do">Add Noun Clause</a>
               		<a href="Sentenses.do">Sentenses</a>
					<a href="SentenceDetail.do">Add Sentence</a>
</span>
               
	<div id="systemPane" style="display:none;">
	
	<div style="float: left; display: block; margin:0 12px 6px 0; width: 200px;">
	<span class="title">Verbs</span><br>
	<a href="VerbDetail.do">new Verb</a>
	
	
	-----<br>
	<a href="SystemCreatesNonnsAndAttrsFromCoreJarOfJ2eeStorys.do">get nouns and attrs from core jar</a>
	
<span class="title">Museigen</span><br>
	<a href="MuseigenNode.do">Museigen Node(Normal size)</a>
	<a href="MuseigenNode.do?fontsize=120">Museigen Node(Dekai)</a>
	<a href="MuseigenNode.do?fontsize=200">Museigen Node(Do-Dekai)</a><br>
	<br>
<span class="title">Tags</span><br>
	<a href="Tags.do">Tags</a><br><br>
</div>

<div style="float: left; display: block; margin:0 12px 6px 0; width: 300px;">
<span class="title">Places</span><br>
	<a href="Places.do">Places</a>
	<a href="PlaceForm.do">New Place</a><br><br>
	
	<span class="title">Purchases</span><br>
	<a href="Perchaces.do">Purchases</a>
	<a href="PurchaseDetail.do">Add purchase</a>	<br><br>
	
<span class="title">action queue</span><br>
	<a href="ActionQueues.do">action queues</a>
	<a href="ActionQueueDetail.do">add action queue </a><br><br>
	
	<span class="title">Estimations</span><br>
	<a href="Estimations.do">Estimations.do</a>
	<a href="EstimationDetail.do">add Estination</a><br><br>
	
	<span class="title">Componey</span>s<br>
	<a href="Componeys.do">Componeys</a>
	<a href="ComponeyDetail.do">add Componey</a><br><br>
	
		<span class="title">NodeCruds</span><br>
	<a href="NodeCruds.do">NodeCruds</a>
	<a href="NodeCrudDetail.do">add NodeCrud</a>
	<a href="NodeDeletes.do">NodeDelete requests</a>
	<a href="NodeCreates.do">NodeCreate requests</a>
	<br>
</div>	
	</div><br>
</div><!-- close system header -->


