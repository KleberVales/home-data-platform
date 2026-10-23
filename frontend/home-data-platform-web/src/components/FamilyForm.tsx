import { useState, type ChangeEvent, type FormEvent } from "react";
import { RELATIONSHIPS, type FamilyRequest } from "../services/familyService";

interface Props {
  onSubmit: (data: FamilyRequest) => Promise<void>;
  submitting: boolean;
}

const INITIAL: FamilyRequest = {
  name: "Maria Silva",
  email: "maria.silva@example.com",
  phone: "+5511998765432",
  relationship: "WIFE",
  birthDate: "1985-06-15",
};

export function FamilyForm({ onSubmit, submitting }: Props) {
  const [form, setForm] = useState<FamilyRequest>(INITIAL);

  const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) =>
    setForm((prev) => ({ ...prev, [e.target.name]: e.target.value }));

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    await onSubmit(form);
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <label>Nome
        <input name="name" value={form.name} onChange={handleChange} required />
      </label>
      <label>E-mail
        <input name="email" type="email" value={form.email} onChange={handleChange} required />
      </label>
      <label>Telefone
        <input name="phone" value={form.phone} onChange={handleChange} required />
      </label>
      <label>Parentesco
        <select name="relationship" value={form.relationship} onChange={handleChange}>
          {RELATIONSHIPS.map((r) => <option key={r} value={r}>{r}</option>)}
        </select>
      </label>
      <label>Nascimento
        <input name="birthDate" type="date" value={form.birthDate} onChange={handleChange} required />
      </label>
      <button type="submit" disabled={submitting}>
        {submitting ? "Salvando..." : "Salvar membro"}
      </button>
    </form>
  );
}
