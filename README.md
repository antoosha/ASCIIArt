# ASCII Art

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)

## Commands
- **--image "path"** - loads image from specified "path"
- **--image-random** - randomly generates image 
- **--brightness "value"** - changes brightness of the image using "value"
- **--flip "axis"** - flipes image by specified axis
- **--invert** - inverts image's color
- **--table "name"** - defines conversion table by parameter "name" to use for conversion
- **--custom-table "values"** - defines custom conversion table via "values"
- **--output-console** - chooses output to console
- **--output-file "file"** - chooses output to file with filename "file"

## Examples

--image "images/image1.png" --output-file "output.txt"

--image "images/image1.png" --flip x --output-console

--image "images/image1.png" --output-file "output.txt"

--image "images/image5.png" --brightness -100 --output-file "output.txt"

--image "images/image5.png" --brightness +200 --output-file "output.txt"

--image "images/image5.png" --invert --output-file "output.txt"

--image "images/image5.png" --flip x --flip y --output-file "output.txt"

--image-random --output-file "output.txt"

## Thank you! 😊
