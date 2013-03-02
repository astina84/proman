// @autor : Jasmir Dzidic
// @date : 16.08.2012
// @version : 0.9
// @dependencies: JQuery 1.7.3
//
/////////////////////////////////////////////////////////////////


// Einen button im metrostyle erstellen (name=bezeichnung des buttons, color=farbe des buttons von 1-10)
function metrobutton(name,color,top,left){
		
	//Variable für die ausgabe der html syntax 
	var output;
	
	// Positionsarray für die kleinen lbl's 
	var positionLeft = new Array(0,52,104,156,208,208,208,208,208,156,104,52,0,0,0,0);
	var positionTop = new Array(0,0,0,0,0,52,104,156,208,208,208,208,208,156,104,52);
	
	// Switchverzweigung zur auswahl der button farben und der hover farbe (1-10 zulässig)
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
	default: alert("Parameter color nur Werte zwischen 1-10");
	
	}
	
	// CSS Style für den metrobutton
	// Allgemein für alle lbl's
	output = '<style type="text/css">.box_'+name+'{position:relative;top:'+top+'px;left:'+left+'px;}.metrobutton_'+name+'{color:white;line-height: 50px;vertical-align:middle;text-align:center;cursor:pointer;}';
	output += '.lbl_'+name+'{overflow:hidden;display:none;background-color:#'+color+';position:absolute;font-size:x-small;height:50px;width:50px;}.lbl_'+name+':hover{background-color:#'+darkcolor+';}';
	output += '.lbl_'+name+'_center{background-color:#'+color+';position:absolute;font-size:x-large;width:154px;height: 154px;line-height:154px;}.lbl_'+name+'_center:hover{background-color: #'+darkcolor+';}';
	// CSS Style für die kleinen lbl's
	for(var i=1;i<17;i++){
	output += ' #lbl_'+name+'_'+i+' { top: '+positionTop[i-1]+'px; left: '+positionLeft[i-1]+'px;}';	
	}
	// CSS Style für das mittlere lbl
	output +='#lbl_'+name+'_center{top:52px;left:52px;}</style>';
		
	// DIV's für den metrobutton
	output += '<div class="box_'+name+'">';
	output += '<div class="metrobutton_'+name+'">';
	for(var i=1;i<17;i++){		
		output += '<div class="lbl_'+name+'" id="lbl_'+name+'_'+i+'">'+i+'halllllllllooo</div>';
	}
	output += '<div class="lbl_'+name+'_center" id="lbl_'+name+'_center">'+name+'</div></div></div>';
	
	// Ausgabe des CSS Styles und der DIV's
	document.write(output);
	
	// Setzen der Mouse Eventhandler
	var lblcenter = '.lbl_'+name+'_center';
	var lbl = '.lbl_'+name+''; 
	var metrobutton = '.metrobutton_'+name+'';

	// FadeIn function bei betreten des lblcenter elements
	$(lblcenter).mouseover(function(){$(lbl).fadeIn(300);}); 
	
	// FadeOut function bei herrausgehen des gesamten buttons
	 $(document).mousemove(function(e){
  
		 // Bestimmung der position des metrobutton elements 
	      var position = $(metrobutton).offset();
	      
	      // Abfrage der mouseposition und abgleich mit der metrobuttongrenze (+2 toleranz) --> fadeOut für lbl element
	      if(e.pageX < (position.left+2) || e.pageX > (position.left+252) || e.pageY < (position.top+2) || e.pageY > (position.top+252) ){
	    	  $(lbl).fadeOut(300);  
	      }
	 
	 });
	 

	// Set Methode für die mouseonclick methode der gesamten button elemente (verwendet zum verlinken)
	function setOnclick(valuearray){
		
	}
	
	this.setOnclick = setOnclick();
	
	
}