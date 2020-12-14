/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size){
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;

  this.getHeroElement = function(){
    return '<img width="'+ this.size + '"' +
      ' height="'+ this.size + '"' +
      ' src="' + this.image +'"' +
      ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
  };

  this.moveRight = function(){
    this.left += 300;
    console.log('ok: ' + this.left);
  };
  this.moveDown = function(){
    this.top += 300;
    console.log('ok: ' + this.left);
  };
  this.moveLeft = function(){
    this.left -= 300;
    console.log('ok: ' + this.left);
  };
  this.moveUp = function(){
    this.top -= 300;
    console.log('ok: ' + this.left);
  };

}

var hero = new Hero('ball.png', 20, 30, 200);

function start(){
  if(hero.left < window.innerWidth - hero.size&&hero.top<hero.size+1){hero.moveRight();}
  if(hero.left + hero.size >= window.innerWidth - hero.size&&hero.top < window.innerHeight - hero.size) {hero.moveDown();}
  if(hero.top >= window.innerHeight - hero.size&&hero.left>=300) {hero.moveLeft();}
  if(hero.left<=300&&hero.left < window.innerWidth - hero.size) {hero.moveUp();}

  document.getElementById('game').innerHTML = hero.getHeroElement();
  setTimeout(start, 500)
}

start();