git user.email

git config --local user.email "new_email@gmail.com.com"

В каталоге репозитория git выполните команду git config user.name .

### Почему важно выполнить эту команду в вашем каталоге git repo?
Если вы находитесь за пределами репозитория git, git config user.name дает вам значение user.name на глобальном уровне. Когда вы делаете фиксацию(коммит), связанное с ней имя пользователя считывается на локальном уровне.




Проверьте имя пользователя

git config user.name
Установить имя пользователя

git config user.name "your_name"
Проверьте свой email

git config user.email

Установите/измените свой email
git config user.email "your@email.com"

Список/просмотр всех конфигураций

git config --list

eval `ssh-agent -s`
ssh-add