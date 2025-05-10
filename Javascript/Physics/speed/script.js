const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");

const config = {
  width: 512,
  height: 512,
  fps: 30,
};

const objArray = [
  { x: 10, y: 10, w: 50, h: 100, c: "#7f007f", v: { x: 10, y: 10 } },
  { x: 128, y: 500, w: 256, h: -100, c: "#7f007f", v: { x: 20, y: -50 } },
  { x: 502, y: 10, w: -50, h: 100, c: "#7f007f", v: { x: -50, y: 1 } },
];

// function paint(x, y, color) {
//   ctx.fillStyle = color;
//   ctx.fillRect(x, y, 1, 1);
// }

// function paintRect(x, y, width, height, color) {
//   const x2 = x + width;
//   const y2 = y + height;
//   for (let i = Math.min(y, y2); i < Math.max(y, y2); i++) {
//     for (let j = Math.min(x, x2); j < Math.max(x, x2); j++) {
//       paint(j, i, color);
//     }
//   }
// }

function paintRect(x, y, width, height, color) {
  ctx.fillStyle = color;
  ctx.fillRect(x, y, width, height);
}

function clear() {
  ctx.fillStyle = "#000000";
  ctx.fillRect(0, 0, config.width, config.height);
}

function arrayPaintRect(array) {
  clear();
  array.map((obj) => paintRect(obj.x, obj.y, obj.w, obj.h, obj.c));
}

function moveObj(array) {
  array.map((obj) => {
    obj.x += obj.v.x / config.fps;
    obj.y += obj.v.y / config.fps;
  });
}

function start() {
  canvas.width = config.width;
  canvas.height = config.height;
  arrayPaintRect(objArray);
  setInterval(() => {
    moveObj(objArray);
    arrayPaintRect(objArray);
  }, 1000 / config.fps);
}

start();
