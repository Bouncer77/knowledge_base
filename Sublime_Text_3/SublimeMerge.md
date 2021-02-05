# Sublime Merge

[sublimemerge](https://www.sublimemerge.com/docs/command_line)

1. Windows: Add C:\Program Files\Sublime Merge to your %PATH%
2. git config mergetool.smerge.cmd 'smerge mergetool "$BASE" "$LOCAL" "$REMOTE" -o "$MERGED"'
3. git config mergetool.smerge.trustExitCode true
4. git config merge.tool smerge
5. Запустить: git mergetool