FROM eclipse-temurin:17-jdk

# 開発・ビルドに必要なツールのインストール
RUN apt-get update && apt-get install -y maven sudo && \
    useradd -m vscode && \
    echo "vscode ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

WORKDIR /workspaces/fe-reading-tool

# --- 本番（Render）用の設定 ---

# 1. ファイルをコンテナ内にコピー
COPY . .

# 2. アプリをビルド（ここで \ を使うと見やすくなります）
RUN ./mvnw clean package \
    -DskipTests

# 3. 起動コマンド（JShellエラーを防ぐ）
# jarファイル名は、以前の成功時の名前に合わせてください
CMD ["java", "-jar", "target/fe-reading-tool-0.0.1-SNAPSHOT.jar"]