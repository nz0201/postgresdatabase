document.addEventListener('DOMContentLoaded', () => {
    const colorInput = document.getElementById('colorInput');
    const widthInput = document.getElementById('widthInput');
    const heightInput = document.getElementById('heightInput');

    function editRectangle() {
        rectangleDisplay.style.backgroundColor = colorInput.value;
        rectangleDisplay.style.width = widthInput.value;
        rectangleDisplay.style.height = heightInput.value;
    }
    
    colorInput.addEventListener('input', editRectangle);
    widthInput.addEventListener('input', editRectangle);
    heightInput.addEventListener('input', editRectangle);
});
