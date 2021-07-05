# Поиск в файлах 

Команда для рекурсивного обхода всех папок и поиска внутри файлов, имена которых удовлетворяют регулярному выражению, вхождение строки

```bash
find . -name "*.java" -exec grep --color -ainHP 'main' {} \; | less
```

# BOM 

```bash
# - удалить BOM маркер
find . -type f -exec sed '1s/^\xEF\xBB\xBF//' -i {} \; 

# - показать все файлы, содержащие BOM маркер (только UTF-8) (https://en.wikipedia.org/wiki/Byte_order_mark)
grep -rl $'\xEF\xBB\xBF' . 
```

CI/CD для бд: https://confluence.tsconsulting.com/pages/viewpage.action?pageId=89466233