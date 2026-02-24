FROM eclipse-temurin:17-jdk

# git を追記
RUN apt-get update && apt-get install -y maven sudo git && \
    useradd -m vscode && \
    echo "vscode ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

WORKDIR /workspaces/e-reading-tool
USER vscode