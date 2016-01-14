function y2k(number) { return (number < 1000) ? number + 1900 : number; }

function padout(number) { return (number < 10) ? '0' + number : number; }

function showDates() {
	 Now=new Date();
	 startDate = new Date(Now.getYear(),Now.getMonth() ,Now.getDate());
	 endDate = new Date(Now.getYear(),Now.getMonth() ,Now.getDate()+20);
	  for (;;) {
	       // infinite loop
	       if (startDate > endDate) {
	        // break out of infinte loop and function
	        return;
	       }
	// document.write("<OPTION VALUE='+y2k(startDate.getYear()) + '月' + padout(startDate.getMonth() + 1) + '日' + padout(startDate.getDate())'>"+y2k(startDate.getYear()) + '月' + padout(startDate.getMonth() + 1) + '日' + padout(startDate.getDate()) + "</OPTION>");
	 document.write("<OPTION VALUE="+y2k(startDate.getYear()) + '月' + padout(startDate.getMonth() + 1) + '日' + padout(startDate.getDate())+">"+ '月' + padout(startDate.getMonth() + 1) + '日' + padout(startDate.getDate()) + "</OPTION>");
	 startDate = new Date(startDate.getTime() + 1*24*60*60*1000);
	 }
				//return line;
}
