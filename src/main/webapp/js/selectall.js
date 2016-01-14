function checkall()
{
void(d=document);
void(el=d.getElementsByName('cid'));
for(i=0;i<el.length;i++)
void(el[i].checked=1)
}
function uncheckall()
{
void(d2=document);
void(e2=d2.getElementsByName('cid'));
for(i=0;i<el.length;i++)
void(el[i].checked=0)
}

function Check(chk)
{
if(document.inbox.Check_All.value=="Check All"){
for (i = 0; i < chk.length; i++)
chk[i].checked = true ;
document.inbox.Check_All.value="UnCheck All";
}else{

for (i = 0; i < chk.length; i++)
chk[i].checked = false ;
document.inbox.Check_All.value="Check All";
}
}