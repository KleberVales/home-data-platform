import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// O proxy evita erro de CORS: o navegador chama /api no próprio Vite (5173),
// e o Vite repassa para o backend.
// IDE: 8081 | Docker (8082:8081): 8082
const BACKEND = process.env.VITE_BACKEND_URL ?? "http://localhost:8081";

export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: { "/api": { target: BACKEND, changeOrigin: true } },
  },
});