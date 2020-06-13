<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <div><div>
            <center><img src="https://vignette.wikia.nocookie.net/euphoria-hbo/images/7/72/Mainpage-welcome.png/revision/latest/scale-to-width-down/400?cb=20190805232715"></center>
        </div></div>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="https://vignette.wikia.nocookie.net/euphoria-hbo/images/4/42/Season_1_Banner.jpg/revision/latest/scale-to-width-down/670?cb=20190520224440" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://vignette.wikia.nocookie.net/euphoria-hbo/images/9/93/And_Salt_the_Earth_Behind_You.jpg/revision/latest/scale-to-width-down/670?cb=20190803033806" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://vignette.wikia.nocookie.net/euphoria-hbo/images/8/84/Season_1.jpg/revision/latest/scale-to-width-down/670?cb=20190520224648" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</@c.page>