CREATE TABLE IF NOT EXISTS "image" (
                                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                       filename VARCHAR(255) NOT NULL,
                                       email VARCHAR(255) NOT NULL,
                                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);