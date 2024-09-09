1) O diretório .idea é um diretório de controle do IntelliJ. O ideal é não versioná-lo e, sim, recriá-lo sempre que necessário.
Um possível arquivo de configuração para o  '.gitignore', poderia ser:

```shell

### Git ###
# $ git config --global mergetool.keepBackup false
*.orig
*.BACKUP.*
*.BASE.*
*.LOCAL.*
*.REMOTE.*
*_BACKUP_*.txt
*_BASE_*.txt
*_LOCAL_*.txt
*_REMOTE_*.txt

### Maven ###
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties


### Java ###
*.class
*.log
*.ctxt
.mtj.tmp/
*.jar
*.war
*.nar
*.ear
*.zip
*.tar
*.tar.gz
*.rar
hs_err_pid*
replay_pid*

### Eclipse ###
.metadata
bin/
tmp/
*.tmp
*.bak
*.swp
*~.nib
local.properties
.settings/
.loadpath
.recommenders
.externalToolBuilders/
*.launch
*.pydevproject
.cproject
.autotools
.factorypath
.buildpath
.target
target
.classpath
.project
.tern-project
.texlipse
.springBeans
.recommenders/
.apt_generated/
.apt_generated_test/
.cache-main
.scala_dependencies
.worksheet
.sts4-cache/

### macOS ###
.DS_Store
.AppleDouble
.LSOverride
Icon
._*
.DocumentRevisions-V100
.fseventsd
.Spotlight-V100
.TemporaryItems
.Trashes
.VolumeIcon.icns
.com.apple.timemachine.donotpresent
.AppleDB
.AppleDesktop
Network Trash Folder
Temporary Items
.apdisk
*.icloud

### Windows ###
Thumbs.db
Thumbs.db:encryptable
ehthumbs.db
ehthumbs_vista.db
*.stackdump
[Dd]esktop.ini
$RECYCLE.BIN/
*.cab
*.msi
*.msix
*.msm
*.msp
*.lnk

### Linux ###
*~
.fuse_hidden*
.directory
.Trash-*
.nfs*

### Intellij+all ###
.idea
*.iml
*.ipr
cmake-build-*/
*.iws
out/
.idea_modules/
atlassian-ide-plugin.xml
com_crashlytics_export_strings.xml
crashlytics.properties
crashlytics-build.properties
fabric.properties

### VisualStudioCode ###
.vscode
*.vsix
.history
.ionide
dist
--------------------------

 2 ) O diretório 'CodeGenerator' parece ser um link que foi versionado por aciddente.

 3 ) Implmentar a persistência de 'Telefone'. Parte da operação já está implementada como um componente de *ContatoPessoal*.

 