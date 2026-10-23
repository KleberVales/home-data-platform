import { useCallback, useEffect, useState } from "react";
import { FamilyForm } from "../components/FamilyForm";
import { FamilyTable } from "../components/FamilyTable";
import { familyService, type FamilyMember, type FamilyRequest } from "../services/familyService";

export function FamilyPage() {
  const [members, setMembers] = useState<FamilyMember[]>([]);
  const [loading, setLoading] = useState(true);
  const [submitting, setSubmitting] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const load = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      setMembers(await familyService.list());
    } catch (e) {
      setError(e instanceof Error ? e.message : "Não foi possível carregar os dados.");
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => { load(); }, [load]);

  const handleCreate = async (data: FamilyRequest) => {
    setSubmitting(true);
    setError(null);
    try {
      await familyService.create(data);
      await load();
    } catch (e) {
      setError(e instanceof Error ? e.message : "Não foi possível salvar.");
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <main className="page">
      <h1>Família</h1>

      <section>
        <h2>Novo membro</h2>
        <FamilyForm onSubmit={handleCreate} submitting={submitting} />
      </section>

      {error && <p className="error" role="alert">{error}</p>}

      <section>
        <div className="row">
          <h2>Membros cadastrados</h2>
          <button className="secondary" onClick={load} disabled={loading}>Atualizar</button>
        </div>
        {loading ? <p>Carregando...</p> : <FamilyTable members={members} />}
      </section>
    </main>
  );
}
