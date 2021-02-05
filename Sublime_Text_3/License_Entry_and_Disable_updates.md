# License_Entry and Disable_updates

<!-- MarkdownTOC autolink="true" -->

- [License Entry](#license-entry)
- [Disable updates](#disable-updates)

<!-- /MarkdownTOC -->

## License Entry

Для того, чтобы ввести лицензионный ключ:

1. Перейдите: Help -> Enter License

2. Вставте ключ (вместе со строчки BEGIN LICENSE до END LICENSE влючительно)

Sublime 3.2.2 build 3211

		----- BEGIN LICENSE -----
		Member J2TeaM
		Single User License
		EA7E-1011316
		D7DA350E 1B8B0760 972F8B60 F3E64036
		B9B4E234 F356F38F 0AD1E3B7 0E9C5FAD
		FA0A2ABE 25F65BD8 D51458E5 3923CE80
		87428428 79079A01 AA69F319 A1AF29A4
		A684C2DC 0B1583D4 19CBD290 217618CD
		5653E0A0 BACE3948 BB2EE45E 422D2C87
		DD9AF44B 99C49590 D2DBDEE1 75860FD2
		8C8BB2AD B2ECE5A4 EFC08AF2 25A9B864
		------ END LICENSE ------

[Если лицензия не подошла, то можно найти другие по ссылке](https://gist.github.com/dinhchi27/80d49460fd4529e21e6b60cc77c79b54)

## Disable updates

references.sublime-settings - Default (Слева) и Preferences.sublime-settings - User (Справа)
Нам необходимо будет внести наши изменения в файл User (который в правом окне):

"update_check": false

Пр1
{
	"update_check": false
}

Пр2
{
	"font_size": 9,
	"update_check": false
}