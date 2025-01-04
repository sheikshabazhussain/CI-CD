document.addEventListener('DOMContentLoaded', function () {
  console.log('Dashboard Loaded');
});




	document.getElementById("logout").addEventListener("click", function(event) {
	    event.preventDefault(); // Prevent the default action (if it's a link)
	
	    fetch('/user/logout', {
	      method: 'POST',
	      credentials: 'include',
	    }).then(() => {
	      window.location.href = '/user/login';
	    }).catch((error) => {
	      console.error("Logout failed:", error);
	    });
	  });
	
