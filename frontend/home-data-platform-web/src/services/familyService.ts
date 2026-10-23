export type Relationship =
  | "WIFE" | "HUSBAND" | "SON" | "DAUGHTER"
  | "FATHER" | "MOTHER" | "BROTHER" | "SISTER" | "OTHER";

// Ajuste a lista acima para bater com o enum do seu backend.
export const RELATIONSHIPS: Relationship[] = [
  "WIFE", "HUSBAND", "SON", "DAUGHTER", "FATHER", "MOTHER", "BROTHER", "SISTER", "OTHER",
];

export interface FamilyRequest {
  name: string;
  email: string;
  phone: string;
  relationship: Relationship;
  birthDate: string; // yyyy-MM-dd
}

export interface FamilyMember extends FamilyRequest {
  id: string | number;
}

const BASE_URL = "/api/family";

async function request<T>(url: string, init?: RequestInit): Promise<T> {
  const res = await fetch(url, {
    headers: { "Content-Type": "application/json" },
    ...init,
  });
  if (!res.ok) {
    const body = await res.text().catch(() => "");
    throw new Error(`Erro ${res.status}${body ? `: ${body}` : ""}`);
  }
  return res.status === 204 ? (undefined as T) : res.json();
}

export const familyService = {
  list: () => request<FamilyMember[]>(BASE_URL),
  create: (data: FamilyRequest) =>
    request<FamilyMember>(BASE_URL, { method: "POST", body: JSON.stringify(data) }),
};
