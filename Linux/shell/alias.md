### Создание псевдонимов (alias)

`~/.bashrc` - Каждый раз выполняется при запуске терминала

alias c='clear' | Создать alias на сеанс
с               | Использование
unalias c       | Удалить alias      


```bash
alias rm='rm -i'
alias cp='cp -i'
alias mv='mv -i'

alias egrep='egrep --color=auto'
alias fgrep='fgrep --color=auto'
alias grep='grep --color=auto'
alias l.='ls -d .* --color=auto'
alias ll='ls -l --color=auto'
alias ls='ls --color=auto'
alias mc='. /usr/libexec/mc/mc-wrapper.sh'
alias sup='sudo su postgres'
alias which='alias | /usr/bin/which --tty-only --read-alias --show-dot --show-tilde'

alias c='clear'
alias ports='netstat -tulanp'
```


