var likeCounter = 0;
function like(){
    likeCounter += 1;
    document.getElementById("likes").innerHTML = likeCounter;
}

var dislikeCounter = 0;
function dislike(){
    dislikeCounter += 1;
    document.getElementById("dislikes").innerHTML = dislikeCounter;
}