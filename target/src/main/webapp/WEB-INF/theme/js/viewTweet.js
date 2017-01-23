$(function() {
	//load tweets at page load in first time
	LoadTweets();
	
	//call ajex function to load the page every munite.
	setTimeout(function () {
		// based on requirement every munite get latest 10 tweets( so every munite I remove the filter if has value and get the last 10)
		$('#filter').val("");
		LoadTweets(); 
    }, 60000);

	/**
	 * on key up start searching
	 * **/
	$('#filter').on('keyup', function(){

		var filerVal = $('#filter').val();
		
			LoadTweets(); 
			
		});
	/**
	 * handle submit!-- when enter pressed
	 */
	$('#filter').on('keydown', function(e){
		if(e.which == 13) 
			LoadTweets(); 
	});
});

/**
 * this is ajex method which call tweets controller and get the data based on filter
 */
function LoadTweets()
{
	var filerVal = $('#filter').val();
	$.ajax({
        url: "tweets?filter=" + filerVal,
        type: 'GET',
        success: function(response) {
            $('.tweets-content').html(response);
        }
    });

}