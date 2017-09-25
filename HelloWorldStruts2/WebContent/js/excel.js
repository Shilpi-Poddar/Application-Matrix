function fnExcelReport()
{
    var tab_text = '<table border="1px">';
    var textRange; 
    var j = 0;
    var k = 0;
    var tab = document.getElementById('myTable'); // id of table
    var tabreverse = document.getElementById('myTable_reverse');
    var lines = tab.rows.length;
    var linesreverse = tabreverse.rows.length;

    // the first headline of the table
    if (lines > 0) {
        tab_text = tab_text + '<tr bgcolor="#DFDFDF">' + tab.rows[0].innerHTML + '</tr>';
    }

    // table data lines, loop starting from 1
    for (j = 1 ; j < lines; j++) {     
        tab_text = tab_text + "<tr>" + tab.rows[j].innerHTML + "</tr>";
    }
    
    if (linesreverse > 0) {
    	tab_text = tab_text + '<tr bgcolor="#DFDFDF">' + tabreverse.rows[0].innerHTML + '</tr>';
    }
    
    for (k = 1 ; k < linesreverse ; k++ ) {
    	tab_text = tab_text + "<tr>" + tabreverse.rows[k].innerHTML + "</tr>";
    }

    tab_text = tab_text + "</table>";
    tab_text = tab_text.replace(/<A[^>]*>|<\/A>/g, "");             //remove if u want links in your table
    tab_text = tab_text.replace(/<img[^>]*>/gi,"");                 // remove if u want images in your table
    tab_text = tab_text.replace(/<input[^>]*>|<\/input>/gi, "");    // removes input parameter
    // console.log(tab_text); // activate so see the result (press F12 in browser)*/

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE "); 

     // if Internet Explorer
    if (msie > 0 ) {
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write(tab_text);
        txtArea1.document.close();
        txtArea1.focus(); 
        sa = txtArea1.document.execCommand("SaveAs", true, "DataTableExport.xlsx");
    }  
    else // other browser not tested on IE 11
    	
    
        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

    return (sa);
}  