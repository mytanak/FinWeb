function horizontal() {
 
   var navItems = document.getElementById("menu_dropdown").getElementsByTagName("li");
    
   for (var i=0; i< navItems.length; i++) {
      if(navItems[i].className == "submenu")
      {
         if(navItems[i].getElementsByTagName('ul')[0] != null)
         {
            navItems[i].onmouseover=function() {this.getElementsByTagName('ul')[0].style.display="block";this.style.backgroundColor = "#";}
            navItems[i].onmouseout=function() {this.getElementsByTagName('ul')[0].style.display="none";this.style.backgroundColor = "#";}
         }
      }
   }
 
}