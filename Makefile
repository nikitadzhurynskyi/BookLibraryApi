compose.up:
	docker compose --env-file .env -f docker/docker-compose.yml up -d
compose.down:
	docker compose --env-file .env -f docker/docker-compose.yml down