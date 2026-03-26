DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'medical_mock') THEN
        CREATE DATABASE medical_mock;
    END IF;
END $$;