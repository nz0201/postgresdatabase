document.addEventListener('DOMContentLoaded', () => {
    const nameInput = document.getElementById('nameInput');
    const colorInput = document.getElementById('colorInput');
    const widthInput = document.getElementById('widthInput');
    const heightInput = document.getElementById('heightInput');

    function addRectangle() {
        rectangle.innerHTML = nameInput.value;
        rectangle.style.backgroundColor = colorInput.value;
        rectangle.style.width = widthInput.value;
        rectangle.style.height = heightInput.value;
    }
    nameInput.addEventListener('input', addRectangle);
    colorInput.addEventListener('input', addRectangle);
    widthInput.addEventListener('input', addRectangle);
    heightInput.addEventListener('input', addRectangle);
});
