echo "jar 파일 생성"
./gradlew build jar -x test

echo "도커 이미지 빌드"
docker-compose build --no-cache

echo "도커 컨테이너 생성 및 실행"
docker-compose up --force-recreate -d
