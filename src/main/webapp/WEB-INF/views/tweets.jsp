<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty tweets}">
	<c:forEach var="tweet" items="${tweets}">
		<div class="tweet-row">
			<div class="tweet-image">
				<img src="${tweet.userProfileImage}" />
			</div>
			<div class="tweet-details">
			<div>
				<span class="user-name">${tweet.userName}</span>
				<span class="screen-name">
					@${tweet.userScreenName}</span>
					</div>
				<div class="tweet-text">${tweet.tweetContent}</div>
				<div class="retweeted">re-tweet: ${tweet.retweeted}</div>
			</div>
		</div>
			<hr>
	</c:forEach>

</c:if>