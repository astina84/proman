var buttonparam = new Array();

function metroButton(name,color,buttonparam){
	
	switch(color){
	case 1: color = "27B1B1";
			darkcolor ="1C7D7D";
		break;
	case 2: color = "FF6820";
			darkcolor ="CC531A";
		break;
	case 3: color = "BB00BB";
			darkcolor ="870087";
		break;
	case 4: color = "22B14C";
			darkcolor ="187D36";
		break;
	case 5: color = "3F48CC";
			darkcolor ="2F3699";
		break;
	case 6: color = "B5E61D";
			darkcolor ="8CB317";
		break;
	case 7: color = "C8BFE7";
			darkcolor ="9D96B5";
		break;
	case 8: color = "FFC90E";
			darkcolor ="CCA10B";
		break;
	case 9: color = "BB00F3";
			darkcolor ="9300BF";
		break;
	case 10: color = "EDE91F";
			darkcolor ="BAB718";
		break;
	default: document.write("Parameter color nur Werte zwischen 1-10");
	
	}

	var buttonhtml = '<style type="text/css">.buttontab'+name+'{text-align:center;color:white;cursor:pointer;width:262px;height:262px;margin:0px;padding:0px;}.tdinnertab'+name+'{font-size:x-small;overflow:hidden;width:50px;height:50px;max-width:50px;max-height:50px;margin:0;padding:0;background-color:#'+color+';visibility:hidden;}.tdcenter'+name+'{font-size:x-large;background-color:#'+color+'}</style> <html> <div class="metrobutton'+name+'" id="metrobutton'+name+'"> <table class="buttontab'+name+'"> <tr> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_1" onmouseout=setBack("btn_'+name+'lbl_1","#'+color+'");setDisplayOff("'+name+'"); onmouseover=setDarker("btn_'+name+'lbl_1","#'+darkcolor+'") '+buttonparam[1]+'>1</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_2">2</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_3">3</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_4">4</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_5">5</td> </tr> <tr> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_16">16</td> <td colspan="3" rowspan="3" class="tdcenter'+name+'" id="tdcenter'+name+'" onmouseover=setDisplayOn("'+name+'")>'+name+'</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_6">6</td> </tr> <tr> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_15">15</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_7">7</td> </tr> <tr> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_14">14</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_8">8</td> </tr> <tr> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_13">13</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_12">12</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_11">11</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_10">10</td> <td class="tdinnertab'+name+'" id="btn_'+name+'lbl_9">9</td> </tr> </table> </div> </html>'; 
	document.write(buttonhtml);

}
function setDarker(elementID,darkcolor)
{
	element = document.getElementById(elementID);
	// Hintergrund Farbe ändern darkcolor verwenden
	element.style.backgroundColor = darkcolor;
}
// function um die Buttons von der Farbe zurück zu setzen
function setBack(elementID,color)
{
	element = document.getElementById(elementID);
	// Hintergrund Farbe ändern und color verwenden
	element.style.backgroundColor = color;
}
// function um die kleinen Buttons auserhalb anzuzeigen
function setDisplayOn(name)
{
	for(var i=1;i<17;i++){
		element = document.getElementById('btn_'+name+'lbl_'+i+'');
	 	element.innerHTML = i;
	 	element.style.visibility = "visible";}
}
//function um die kleinen Buttons zu verstecken
function setDisplayOff(name)
{
	for(var i=1;i<17;i++){
		element = document.getElementById('btn_'+name+'lbl_'+i+'');
	 	element.innerHTML = i;
	 	element.style.visibility = "hidden";}
}
	
